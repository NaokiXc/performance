<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container">
        Laggards in all subjects
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Student</th>
                <th scope="col">Avg</th>
            </tr>
            </thead>
            <tbody>
            <#list studentsAsc as key, value>
                <#if key.studentId??>
                    <tr>
                        <td>${key.getFullName()} </td>
                        <td>${value}</td>
                    </tr>
                    </#if>
                <#else>
                    Students not found
            </#list>
            </tbody>
        </table>
    </div>

    <div class="container">
        Leaders in all subjects
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Student</th>
                <th scope="col">Avg</th>
            </tr>
            </thead>
            <tbody>
            <#list studentsDesc as key, value>
                <#if key.studentId??>
                    <tr>
                        <td>${key.getFullName()} </td>
                        <td>${value}</td>
                    </tr>
                </#if>
            <#else>
                Students not found
            </#list>
            </tbody>
        </table>
    </div>

</@c.page>
