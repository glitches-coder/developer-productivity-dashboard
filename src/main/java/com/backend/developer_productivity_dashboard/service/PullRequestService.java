package com.backend.developer_productivity_dashboard.service;

import com.backend.developer_productivity_dashboard.models.PullRequestPayLoad;
import com.backend.developer_productivity_dashboard.repository.PullRequestEventRepository;
import com.backend.developer_productivity_dashboard.utilities.PullRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PullRequestService {

    @Autowired
    private PullRequestEventRepository preRepo;

    public void pullRequestEvent(PullRequestPayLoad pullRequestPayLoad) {
        PullRequestMapper prMapper = new PullRequestMapper();
        preRepo.save(prMapper.fromPayload(pullRequestPayLoad));
    }
}
