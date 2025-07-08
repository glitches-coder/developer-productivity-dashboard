package com.backend.developer_productivity_dashboard.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("Commits")
public class CommitEvent {

    @Id
    private String id;

    private String pusherName, commiterName, author, ref;
    private String repoName, url, message, distinct, commiterUsername;
    private String authorEmail, commiterEmail;
    private Date timeStamp;

}
