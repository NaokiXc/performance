<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/performance" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by surName">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
                <div id="browse_app">
                    <a class="btn btn-large btn-secondary" href="/performance/add">Add new</a>
                </div>
                <div>
                    <a class="btn btn-large btn-info" href="/performance/rating">Rating</a>
                </div>
            </form>
        </div>
    </div>
    <div class="student-container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Student</th>
                <th scope="col">Subject</th>
                <th scope="col">Lecturer</th>
                <th scope="col">Value</th>
            </tr>
            </thead>
            <tbody>
            <#list performances as performance>
                <#if performance.performanceId??>
                    <tr>
                        <td>${performance.student.getFullName()}</td>
                        <td>${performance.subject.subjectName}</td>
                        <td>${performance.lecturer.getFullName()}</td>
                        <td>${performance.value}</td>
                    </tr>
                </#if>

            <#else>
                Performances not found
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>
