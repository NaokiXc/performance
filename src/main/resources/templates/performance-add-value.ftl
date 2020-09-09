<#import "parts/common.ftl" as c>

<@c.page>
    Students performance of ${student.getFullName()} (input value):

    <a href="/performance/add/${student.studentId}/${subject.subjectId}/${lecturer.lecturerId}" class="btn btn-primary" role="button">Back</a>

    <ul class="list-group m-2">
        INFO
        <li class="list-group-item">Student name: ${student.getFullName()}</li>
        <li class="list-group-item">Subject: ${subject.subjectName}</li>
        <li class="list-group-item">Lecturer: ${lecturer.getFullName()}</li>
    </ul>

    <form action="/performance" method="post">
        <select class="browser-default custom-select m-2" name="value">
            <option selected>Choose value/option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>

        <button type="submit" class="btn btn-primary mb-2">Save</button>

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="hidden" value="${student.studentId}" name="studentId">
        <input type="hidden" value="${subject.subjectId}" name="subjectId">
        <input type="hidden" value="${lecturer.lecturerId}" name="lecturerId">
    </form>
</@c.page>

