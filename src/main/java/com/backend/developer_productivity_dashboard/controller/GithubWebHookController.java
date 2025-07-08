package com.backend.developer_productivity_dashboard.controller;


import com.backend.developer_productivity_dashboard.models.PullRequestPayLoad;
import com.backend.developer_productivity_dashboard.models.PushPayLoad;
import com.backend.developer_productivity_dashboard.service.CommitEventService;
import com.backend.developer_productivity_dashboard.service.PullRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class GithubWebHookController {

    @Autowired
    private CommitEventService commitEventService;

    @Autowired
    private PullRequestService pullRequestService;



    @PostMapping("/github/push")
    public ResponseEntity<Void> pushWebHookData(@RequestBody PushPayLoad pushPayLoad,
                                                @RequestHeader("X-GitHub-Event") String event) {
        if ("push".equals(event)) {
            commitEventService.pushEvent(pushPayLoad);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/github/pr")
    public ResponseEntity<Void> pullRequestWebHookData(@RequestBody PullRequestPayLoad pr,
                                                @RequestHeader("X-GitHub-Event") String event) {

        if ("pull_request".equals(event)) {
            pullRequestService.pullRequestEvent(pr);
        }
        return ResponseEntity.ok().build();

    }

}

