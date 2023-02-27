package com.example.practicalenoch.model

data class BranchResponse(
	val branchResponse: List<BranchResponseItem?>? = null
)

data class BranchCommit(
	val sha: String? = null,
	val url: String? = null
)

data class BranchResponseItem(
	val jsonMemberProtected: Boolean? = null,
	val name: String? = null,
	val commit: BranchCommit? = null
)

