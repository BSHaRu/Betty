<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section class="signup spad">
		<div class="row justify-content-center">
			<div class="col-md-auto">
				<div class="login__form">
					<div class="section-title">
						<div class="row justify-content-between">
							<div class="col-auto">
								<h4><s:message code="text.user.info"/></h4>
							</div>
							<div class="col-auto">
								<button class="btn btn-danger"
									onclick="location.href='${path}/staff/${user.id}/edit'"><s:message code="btn.modify"/></button>
								<button class="btn btn-secondary ml-3"
								data-toggle="modal"
								data-target="#withdrawMember" ><s:message code="btn.member.delete"/></button>
							</div>
						</div>
					</div>
		
					<img class="img-thumbnail" alt="..."
						src="${path}/resources/img/member/middle/${user.img}" />
					<div class="w-100 mb-5"></div>
					<form id="info">
						<input type="text" name="rights" value="0" hidden/>
						<s:message code="text.id"/>
						<div class="input__item">
							<span><i class="bi bi-person-circle"></i></span>
							<input type="text" name="id" id="id" value="${user.id}" readonly/> 
						</div>
						<s:message code="text.name"/>
						<div class="input__item">
							<span class="icon_profile"></span> 
							<input type="text" name="name" id="name" value="${user.name}" readonly/>
						</div>
						<s:message code="text.nickname"/>
						<div class="input__item">
							<span><i class="bi bi-person-video2"></i></span> 
							<input type="text" name="nickname" id="nickname" value="${user.nickname}" readonly/>
						</div>
						<s:message code="text.birth"/>
						<div class="input__item">
							<span><i class="bi bi-calendar3"></i></span>
							<input type="text" name="birth" value="<f:formatDate value="${user.birth}" pattern="yyyy-MM-dd"/>" readonly/> 
						</div>
						<s:message code="text.gender"/>
						<div class="btn-group btn-group-toggle w-100"  data-toggle="buttons">
							<label class="btn btn-outline-secondary text-white radio-gender">
								<input type="radio" name="gender" id="male" value="male" /> <s:message code="gender.male"/>
							</label>
							<label class="btn btn-outline-secondary ml-2 text-white radio-gender">
								<input type="radio" name="gender" id="female" value="female" /> <s:message code="gender.female"/>
							</label>
						</div>
							<div class="mb-3"></div>
						
						<s:message code="text.address"/>
						<div class="mb-4">
							<div class="row addr-box">
								<div class="col-md-8 mb-4 ">
									<input type="text" class="form-control" name="post" id="post" value="${user.post}" readonly/>
								</div>
								<div class="col-md-3" style="padding-right:0">
								</div>
							</div>
							<input type="text" class="form-control mb-4" name="addr" id="addr" value="${user.addr}" readonly/>
							<input type="text" class="form-control" name="addrDetail" id="addrDetail" value="${user.addrDetail}" readonly/>
						</div>
						
						 <s:message code="text.phone"/>
						<div class="input__item">
							<span><i class="bi bi-phone"></i></span>
							<input type="text" name="phone" id="phone"  value="${user.phone}" /> 
						</div>
						
						<s:message code="text.email"/>
						<div class="input__item">
							<span class="icon_mail"></span>
							<input type="text" name="email" id="email"  value="${user.email}" /> 
						</div>

					</form>
				</div>
		</div>
	</div>
</section>


<%@include file="/WEB-INF/views/include/footer.jsp"%>

<div class="modal fade" id="withdrawMember" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><s:message code="text.delete.modal.title"/></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" >
        <p id="modal-body" style="color:black"><s:message code="sign.id.req"/></p>
        <input class="form-control" name="id"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="withdrawMemberBtn"><s:message code="btn.member.delete"/></button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><s:message code="btn.cancel"/></button>
      </div>
    </div>
  </div>
</div>

<script>
	if('${user.gender}' == 'male'){
 		$('#male').prop('checked','true');
 		$('#female').prop('disabled','true');
 	} else {
 		$('#female').prop('checked','true');
 		$('#male').prop('disabled','true');
 	}
	
	if("${message}" != ""){
		alert("${message}");
	}
	
	$('#withdrawMemberBtn').click(function(){
		$.ajax({
			url: '${path}/members/${user.id}',
			type: 'delete',
			dataType: 'application/json',
			success: function(){
				alert("삭제 완료");
				location.href='${path}/';
			},
			fail: function(){
			}
		})
	});
</script>








