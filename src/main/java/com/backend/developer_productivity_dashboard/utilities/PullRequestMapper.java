package com.backend.developer_productivity_dashboard.utilities;

import com.backend.developer_productivity_dashboard.models.PullRequestEvent;
import com.backend.developer_productivity_dashboard.models.PullRequestPayLoad;

public class PullRequestMapper {
    public PullRequestEvent fromPayload(PullRequestPayLoad payload) {
        PullRequestEvent event = new PullRequestEvent();
        PullRequestPayLoad.PullRequest pr = payload.getPullRequest();

        event.setAction(payload.getAction());
        event.setNumber(payload.getNumber());

        event.setPullRequestId(pr.getId());
        event.setTitle(pr.getTitle());
        event.setBody(pr.getBody());
        event.setState(pr.getState());
        event.setMerged(pr.isMerged());
        event.setMergeCommitSha(pr.getMergeCommitSha());

        event.setCreatedAt(pr.getCreatedAt());
        event.setUpdatedAt(pr.getUpdatedAt());
        event.setClosedAt(pr.getClosedAt());
        event.setMergedAt(pr.getMergedAt());

        event.setAuthorLogin(pr.getUser().getLogin());

        event.setHeadRef(pr.getHead().getRef());
        event.setHeadSha(pr.getHead().getSha());
        event.setBaseRef(pr.getBase().getRef());
        event.setBaseSha(pr.getBase().getSha());

        event.setCommits(pr.getCommits());
        event.setAdditions(pr.getAdditions());
        event.setDeletions(pr.getDeletions());
        event.setChangedFiles(pr.getChangedFiles());

        PullRequestPayLoad.Repository repo = payload.getRepository();
        event.setRepoName(repo.getName());
        event.setRepoFullName(repo.getFull_name());
        event.setRepoOwner(repo.getOwner().getLogin());

        if (pr.getOrganization() != null) {
            event.setOrganization(pr.getOrganization().getName());
        }

        return event;
    }
}
