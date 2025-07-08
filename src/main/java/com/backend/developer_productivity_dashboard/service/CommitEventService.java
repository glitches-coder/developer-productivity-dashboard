package com.backend.developer_productivity_dashboard.service;

import com.backend.developer_productivity_dashboard.models.CommitEvent;
import com.backend.developer_productivity_dashboard.models.PushPayLoad;
import com.backend.developer_productivity_dashboard.repository.CommitEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitEventService {

    @Autowired
    private CommitEventRepository commitEventRepository;

    public void pushEvent(PushPayLoad payLoad) {
        String repo = payLoad.getRepository().getRepoName();
        String pusher = payLoad.getPusher().getName();
        String ref = payLoad.getRef();

        for (PushPayLoad.Commits c : payLoad.getCommits()) {
            CommitEvent commitEvent = new CommitEvent();
            commitEvent.setRepoName(repo);
            commitEvent.setPusherName(pusher);
            commitEvent.setRef(ref);
            commitEvent.setCommiterName(c.getCommitter().getName());
            commitEvent.setCommiterUsername(c.getCommitter().getUsername());
            commitEvent.setCommiterName(c.getCommitter().getEmail());
            commitEvent.setAuthor(c.getAuthor().getName());
            commitEvent.setAuthor(c.getAuthor().getEmail());
            commitEvent.setUrl(c.getUrl());
            commitEvent.setMessage(c.getMessage());
            commitEvent.setDistinct(c.getDistinct());
            commitEvent.setTimeStamp(c.getTimeStamp());
            commitEventRepository.save(commitEvent);
        }
    }


}
