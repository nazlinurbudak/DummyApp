package com.nazlinurbudak.checker

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

@Suppress("UnstableApiUsage")
class MyIssueRegistry : IssueRegistry() {
    override val issues = listOf(
        DeprecatedClassUsageDetector.ISSUE,
        AndroidLogUsageDetector.ISSUE,
        JavaDetector.ISSUE,
    )

    override val api: Int
        get() = CURRENT_API
}