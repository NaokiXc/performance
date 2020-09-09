<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container mt-5">
        <div class="groups-card-columns">
            <h1> Groups catalog </h1>
            <div class="card">
                <#list groups as group>
                <#if group.groupId??>
                <div class="card my-3">
                    <div class="m-2">
                        <b>${group.groupName}</b>
                    </div>
                    <div class="m-2">
                        <span>Speciality: ${group.speciality}</span>
                    </div>
                    <div class="card-footer text-muted">
                        GroupID: ${group.groupId}
                    </div>
                </div>
                </#if>
            </div>
            <#else>
                Groups not found
            </#list>
        </div>
    </div>

    <div class="container mt-5">
        <div class="groups-card-columns">
        <h1> Subjects catalog </h1>
        <div class="card">
            <#list subjects as subject>
                <div class="card my-3">
                    <div class="m-2">
                        <span>${subject.subjectName}</span>
                    </div>
                </div>
            <#else>
                Subjects not found
            </#list>
        </div>
    </div>

</@c.page>