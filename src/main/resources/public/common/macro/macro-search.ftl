<#macro search labels names isEnd>
    <#list labels as item>
    <div class="input-group " style="margin: 6px">
        <span class="input-group-addon">${item}</span>
        <#assign name = names[item?index]/>
        <input type="text" class="form-control " name="${name}" value="${Request[name]!}" placeholder="${item}">
    </div>
    </#list>
    <#if isEnd>
    <div class="input-group ">
        <button class="btn btn-success" style="margin: 6px">
            <i class="icon-search"></i>搜索
        </button>
    </div>
    </#if>
</#macro>


<#macro searchSelect label name valueMap isEnd>
<div class="input-group " style="margin: 6px">
    <span class="input-group-addon">${label!}</span>
    <select class="form-control" name="${name!}">
        <option value="">请选择${label!}</option>
        <#list valueMap?keys as item>
            <option <#if item! == Request[name]!>selected</#if> value="${item}">${valueMap[item]!}</option>
        </#list>
    </select>
</div>
    <#if isEnd>
    <div class="input-group ">
        <button class="btn btn-success" style="margin: 6px">
            <i class="icon-search"></i>搜索
        </button>
    </div>
    </#if>
</#macro>