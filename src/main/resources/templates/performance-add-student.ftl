<#import "parts/common.ftl" as c>

<@c.page>
    Students performance of ${student.getFullName()} (choose subject):
    <a href="/performance/add/" class="btn btn-primary" role="button">Back</a>
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Subject</th>
                <th scope="col">Link</th>
            </tr>
            </thead>
            <tbody>
            <#list subjects as subject>
                <#if subject.subjectId??>
                    <tr>
                        <td>${subject.subjectName}</td>
                        <td><a href="/performance/add/${student.studentId}/${subject.subjectId}" role="button">Next</a></td>
                    </tr>
                </#if>
            <#else>
                Subjects not found
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>