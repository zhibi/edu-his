<#macro tableHead names>
<thead>
<tr>
    <#list names as item>
        <th>${item!}</th>
    </#list>
</tr>
</thead>
</#macro>

<#macro tableBody model propMap>
    <#list propMap?keys as item>
        <#assign format = propMap[item]/>
        <#if format?length gt 0>
            <#if model[item]??>
            <td>${model[item]!?string(format)}</td><#else>
            <td></td>
            </#if>

        <#else>
        <td>${model[item]!}</td>
        </#if>
    </#list>
</#macro>