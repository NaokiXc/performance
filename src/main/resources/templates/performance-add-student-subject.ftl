<#import "parts/common.ftl" as c>

<@c.page>
    Students performance of ${student.getFullName()} (choose lecturer):
    <a href="/performance/add/${student.studentId}/" class="btn btn-primary" role="button">Back</a>
    <div class="container">

        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Lecturer</th>
                <th scope="col">Link</th>
            </tr>
            </thead>
            <tbody>
            <#list lecturers as lecturer>
            <#if lecturer.lecturerId??>
            <tr>
                <td>${lecturer.getFullName()}</td>
                <td><a href="/performance/add/${student.studentId}/${subject.subjectId}/${lecturer.lecturerId}"
                       role="button">Next</a></td>
            </tr>
            </#if>
            <#else>
            Lecturer not found
        </#list>
        </tbody>
        </table>
    </div>
</@c.page>