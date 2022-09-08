<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container-md spad">
	<div class="row align-items-center">
		<div class="membership_title">
			<h2>멤버십 등급별 안내 항목</h2>
		</div>
		<table class="table margin_bottom">
			<colgroup>
				<col style="width:180px; text-align:center">
			</colgroup>
			<tbody>
				<!-- 멤버십 등급 -->
				<tr class="table_tr">
					<th class="table_th">멤버십 등급</th>
					<td>
						<span>
							<i class="bi bi-hexagon"></i><br/>
							<em>bronze 등급</em>
						</span>
					</td>
					<td>
						<span>
							<i class="bi bi-gift-fill"></i><br/>
							<em>silver 등급</em>
						</span>
					</td>
					<td>
						<span>
							<i class="bi bi-gem"></i><br/>
							<em>vip 등급</em>
						</span>
					</td>
				</tr>
				
				<!-- 등급 기준 -->
				<tr class="table_tr">
					<th class="table_th">월 정액</th>
					<td>0원</td>
					<td>50,000원</td>
					<td>150,000원</td>
				</tr>
				
				<!-- 스터디룸 이용 시간 -->
				<tr class="table_tr">
					<th class="table_th">스터디룸 이용 시간</th>
					<td>이용 불가</td>
					<td>하루 최대 4시간 이용</td>
					<td>자유롭게 이용 가능</td>
				</tr>
				
				<!-- 책 대여 기간 -->
				<tr class="table_tr">
					<th class="table_th">대여 기간</th>
					<td>7일동안 대여 가능	</td>
					<td>14일동안 대여 가능</td>
					<td>30일동안 대여 가능</td>
				</tr>
				
				<!-- 대여 권수 -->
				<tr class="table_tr">
					<th class="table_th">총 대여 권수</th>
					<td>대여기간 동안 최대 1권</td>
					<td>대여기간 동안 최대 2권</td>
					<td>대여기간 동안 최대 3권</td>
				</tr>
				
				<!-- 대여 비용 -->
				<tr class="table_tr">
					<th class="table_th">대여 비용</th>
					<td>1,000원</td>
					<td>500원</td>
					<td>무료</td>
				</tr>
				
				<!-- 연체료 할인률 -->
				<tr class="table_tr">
					<th class="table_th">연체료 할인률</th>
					<td>0%</td>
					<td>10%</td>
					<td>20%</td>
				</tr>
			</tbody>
		</table>
		
		<!-- 참고사항 테이블 -->
		<div class="membership_title">
			<h2>참고 사항</h2>
		</div>
		<table class="table">
			<colgroup>
				<col style="width:180px">
			</colgroup>
			<tbody>
				<tr class="table_tr">
					<th class="table_th">블랙리스트</th>
					<td>
						블랙리스트가 되면 해당 계정은<span class="highlight_font">영구 정지이며,</span><br/>
						동일한 개인정보로 재가입 신청 시 <span class="highlight_font">xx일 동안 가입 할 수 없습니다.</span>
					</td>
				</tr>
				
				<tr class="table_tr">
					<th class="table_th">블랙리스트 기준</th>
					<td>
						반납 기간 기준 <span class="highlight_font">1달 연체시</span><br/>
						게시판 관련 <span class="highlight_font">악의적인 게시시</span>관리자가 판단하에 블랙리스트 처리가 됩니다.
					</td>
				</tr>
				
				<tr class="table_tr">
					<th class="table_th">연체료 기준</th>
					<td>
						연체 금액은 하루에<span class="highlight_font">500원</span>씩 올라가며,<br/>
						연체 기간이 <span class="highlight_font">30일 이상</span>일 경우<span class="highlight_font">해당 책의 정가(권장 소비자가격)</span>에 해당하는 금액을 지불하셔야 됩니다.<br/>
						※연체 기간이 14일 이상되면 전화 및 문자를 남겨드리며, 연체 기간이 30일 이상 넘었고, 책을 미반납 할 시 법적 책임을 질 수도 있습니다.
					</td>
				</tr>
				
			</tbody>
		</table>
	</div>
</div>
