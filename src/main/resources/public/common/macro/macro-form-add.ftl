<#macro formAdd labels names>
    <#list labels as item>
    <div class="form-group has-info">
        <label class="control-label col-sm-2">${item}:</label>
        <div class=" col-sm-8">
            <input class="form-control input-sm" name="${names[item?index]}" type="text" required>
        </div>
    </div>
    </#list>
</#macro>

<#macro formAddNo labels names>
    <#list labels as item>
    <div class="form-group has-info">
        <label class="control-label col-sm-2">${item}:</label>
        <div class=" col-sm-8">
            <input class="form-control input-sm" name="${names[item?index]}" type="text">
        </div>
    </div>
    </#list>
</#macro>

<#macro formAddNum label name>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <input type="number" name="${name!}" required class="form-control input-sm"/>
    </div>
</div>
</#macro>

<#macro formAddDate label name>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <input type="text" name="${name!}" required class="form-control input-sm date-picker" data-date-format="yyyy-mm-dd" readonly/>
    </div>
</div>
</#macro>

<#macro formAddSel label name valueMap>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <select class="form-control col-sm-2 input-sm" name="${name!}">
            <#list valueMap?keys as item>
                <option value="${item}">${valueMap[item]!}</option>
            </#list>
        </select>
    </div>
</div>
</#macro>

<#macro formAddRadio label name valueMap>
<div class="form-group has-info">
    <label class="control-label  col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <#list valueMap?keys as item>
            <input type="radio" name="${name!}" value="${item}" <#if item?index == 0>checked</#if>/> ${valueMap[item]!}
        </#list>
    </div>
</div>
</#macro>

<#macro formAddFile label name>
<div class="form-group has-info">
    <label class="control-label col-sm-2">${label!}:</label>
    <div class=" col-sm-8">
        <input type="file" name="${name!}" required class="form-control"/>
    </div>
</div>
</#macro>