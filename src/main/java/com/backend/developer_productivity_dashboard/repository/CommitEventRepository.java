package com.backend.developer_productivity_dashboard.repository;

import com.backend.developer_productivity_dashboard.models.CommitEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommitEventRepository extends MongoRepository<CommitEvent, String> {

}
