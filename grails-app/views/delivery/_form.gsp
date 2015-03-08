<%@ page import="auction.Delivery" %>



<div class="fieldcontain ${hasErrors(bean: deliveryInstance, field: 'delivery', 'error')} required">
	<label for="delivery">
		<g:message code="delivery.delivery.label" default="Delivery" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="delivery" required="" value="${deliveryInstance?.delivery}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: deliveryInstance, field: 'datecreated', 'error')} required">
	<label for="datecreated">
		<g:message code="delivery.datecreated.label" default="Datecreated" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${deliveryInstance?.datecreated}"  />

</div>

