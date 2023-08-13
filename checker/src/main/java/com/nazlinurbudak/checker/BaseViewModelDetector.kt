package com.nazlinurbudak.checker

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class BaseViewModelDetector : Detector(), SourceCodeScanner {
    companion object {
        @JvmField
        val ISSUE: Issue = Issue.create(
            id = "LogUsage",
            briefDescription = "Using incorrect logging library",
            explanation = """
                    Log should no longer be used. All instances of Log should be replaced with Log.f
                    """,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                AndroidLogUsageDetector::class.java, Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun getApplicableMethodNames() = listOf("d", "w", "f", "e")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (!context.evaluator.isMemberInClass(method, "android.util.Log")) {
            return
        }

        // Check if the method's containing class is BaseViewModel
        val containingClass = method.containingClass
        if (containingClass != null && containingClass.qualifiedName?.contains("BaseViewModel") == true ) {
            val quickFixData = LintFix.create()
                .name("Use Log.f()")
                .replace()
                .text(method.name)
                .with("f")
                .robot(true)
                .independent(true)
                .build()

            context.report(
                issue = ISSUE,
                scope = node,
                location = context.getCallLocation(
                    node,
                    includeReceiver = true,
                    includeArguments = false
                ),
                message = "Use Log.f rather than Log. Log Kullanımın yanlış",
                quickfixData = quickFixData
            )
        }
    }
}