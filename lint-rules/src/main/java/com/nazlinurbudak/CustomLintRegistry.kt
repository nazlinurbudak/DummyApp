package com.nazlinurbudak

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.nazlinurbudak.lint_rules.AndroidLogImportDetector
import com.nazlinurbudak.lint_rules.AndroidLogUsageDetector
import com.nazlinurbudak.lint_rules.DeprecatedClassUsageDetector
import com.nazlinurbudak.lint_rules.NazliDetector

@Suppress("UnstableApiUsage")
class CustomLintRegistry: IssueRegistry() {
    override val issues = listOf(
        AndroidLogUsageDetector.ISSUE,
        DeprecatedClassUsageDetector.ISSUE,
        JavaDetector.ISSUE,
        BaseViewModelDetector.ISSUE
    )

    override val api: Int
        get() = CURRENT_API
}