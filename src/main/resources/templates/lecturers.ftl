<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/lecturers" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by firstName">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <div class="lecturer-container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">LecturerID</th>
                <th scope="col">FirstName</th>
                <th scope="col">LastName</th>
                <th scope="col">Patronymic</th>
                <th scope="col">Subjects</th>
            </tr>
            </thead>
            <tbody>
            <#list lecturers as lecturer>
                <#if lecturer.lecturerId??>
                <tr>
                    <td>${lecturer.lecturerId}</td>
                    <td>${lecturer.firstName}</td>
                    <td>${lecturer.surName}</td>
                    <td>${lecturer.patronymic}</td>
                    <td>${lecturer.getSubjectsString()}</td>
                </tr>
                </#if>
                <#else>
                    Lecturers not found
            </#list>
            </tbody>
        </table>
    </div>

</@c.page>
