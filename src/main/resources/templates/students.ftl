<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/students" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by firstName">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <div class="student-container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">StudentID</th>
                <th scope="col">FirstName</th>
                <th scope="col">LastName</th>
                <th scope="col">Patronymic</th>
                <th scope="col">Date of birth</th>
                <th scope="col">Group</th>
            </tr>
            </thead>
            <tbody>
            <#list students as student>
                <#if student.studentId??>
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.firstName}</td>
                    <td>${student.surName}</td>
                    <td>${student.patronymic}</td>
                    <td>${student.dateOfBirthString}</td>
                    <td>${student.group.groupName}</td>
                </tr>
                </#if>

                <#else>
                    Students not found
            </#list>
            </tbody>
        </table>
    </div>

</@c.page>
