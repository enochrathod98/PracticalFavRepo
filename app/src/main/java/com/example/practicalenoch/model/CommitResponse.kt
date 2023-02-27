package com.example.practicalenoch.model

import com.google.gson.annotations.SerializedName

data class CommitResponse(

	@field:SerializedName("committer")
	val committer: Committer? = null,

	@field:SerializedName("stats")
	val stats: Stats? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("commit")
	val commit: Commit? = null,

	@field:SerializedName("comments_url")
	val commentsUrl: String? = null,

	@field:SerializedName("files")
	val files: List<FilesItem?>? = null,

	@field:SerializedName("sha")
	val sha: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("parents")
	val parents: List<ParentsItem?>? = null
)

data class ParentsItem(

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("sha")
	val sha: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Tree(

	@field:SerializedName("sha")
	val sha: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Stats(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("additions")
	val additions: Int? = null,

	@field:SerializedName("deletions")
	val deletions: Int? = null
)

data class Commit(

	@field:SerializedName("comment_count")
	val commentCount: Int? = null,

	@field:SerializedName("committer")
	val committer: Committer? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("tree")
	val tree: Tree? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("verification")
	val verification: Verification? = null
)

data class Author(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
)

data class Verification(

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("signature")
	val signature: Any? = null,

	@field:SerializedName("payload")
	val payload: Any? = null,

	@field:SerializedName("verified")
	val verified: Boolean? = null
)

data class Committer(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
)

data class FilesItem(

	@field:SerializedName("patch")
	val patch: String? = null,

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("additions")
	val additions: Int? = null,

	@field:SerializedName("deletions")
	val deletions: Int? = null,

	@field:SerializedName("changes")
	val changes: Int? = null,

	@field:SerializedName("sha")
	val sha: String? = null,

	@field:SerializedName("blob_url")
	val blobUrl: String? = null,

	@field:SerializedName("raw_url")
	val rawUrl: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("contents_url")
	val contentsUrl: String? = null
)
