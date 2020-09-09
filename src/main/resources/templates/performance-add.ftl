<#import "parts/common.ftl" as c>

<@c.page>
    Students performance (choose student):
    <a href="/performance" class="btn btn-primary" role="button">Back</a>
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Student</th>
                <th scope="col">Group</th>
                <th scope="col">Link</th>
            </tr>
            </thead>
            <tbody>
            <#list students as student>
                <#if student.studentId??>
                <tr>
                    <td>${student.getFullName()}</td>
                    <td>${student.group.groupName}</td>
                    <td><a href="/performance/add/${student.studentId}">Next</a></td>
                </tr>
                </#if>
            <#else>
                Students not found
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>