package com.backend.developer_productivity_dashboard.repository;

import com.backend.developer_productivity_dashboard.models.PullRequestEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PullRequestEventRepository extends MongoRepository<PullRequestEvent, String> {
}
