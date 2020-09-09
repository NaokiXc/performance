<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">StudentPerformance</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/students">Students List</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/lecturers">Lecturer List</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/catalog">Catalogs </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/performance">Performances </a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>
