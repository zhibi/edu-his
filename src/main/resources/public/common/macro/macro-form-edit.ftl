<#macro formEdit labels names model>
    <#list labels as item>
    <div class="form-group has-info">
        <label class="control-label  col-sm-2">${item}:</label>
        <div class=" col-sm-8">
            <input class="form-control input-sm" name="${names[item?index]}" value="${model[names[item?index]]!}" type="text"
                   required>
        </div>
    </div>
    </#list>
</#macro>

<#macro formEditNo labels names model>
    <#list labels as item>
    <div class="form-group has-info">
        <label class="control-label col-sm-2">${item}:</label>
        <div class=" col-sm-8">
            <input class="form-control input-sm" name="${names[item?index]}" value="${model[names[item?index]]!}" type="text">
        </div>
    </div>
    </#list>
</#macro>


<#macro formEditNum label name model>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <input type="number" name="${name!}" value="${model[name]!?string('#0')}" required class="form-control"/>
    </div>
</div>
</#macro>

<#macro formEditDate label name model>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <input type="text" name="${name!}" value="${model[name]!}" required class="form-control date-picker" data-date-format="yyyy-mm-dd" readonly/>
    </div>
</div>
</#macro>

<#macro formEditSel label name valueMap model>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <select class="form-control input-sm col-sm-2" name="${name!}">
            <#list valueMap?keys as item>
                <option <#if item=model[name]!?string>selected</#if> value="${item}">${valueMap[item]!}</option>
            </#list>
        </select>
    </div>
</div>
</#macro>

<#macro formEditRadio label name valueMap model>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <#list valueMap?keys as item>
            <input type="radio" name="${name!}" value="${item}" <#if item == model[name]?string>checked</#if>/> ${valueMap[item]!}
        </#list>
    </div>
</div>
</#macro>