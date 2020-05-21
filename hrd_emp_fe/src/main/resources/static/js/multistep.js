	function showAlert() {

		alert("Success!!");
	}

	$(document).ready(
			function() {
				$("#divTab2").hide();
				$("#divTab3").hide();
				$("#divTab4").hide();
				$("#divTab5").hide();
				$("#divTab6").hide();
				$("#divTab7").hide();
				$("#divTab1Details").attr('class',
						'mdl-stepper-step active-step');

				$("#divTab1Details").click(function() {
					console.log("Tab1 Details");
					$("#divTab1").show();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#divTab2Details").click(function() {
					console.log("Tab2 Details");
					$("#divTab1").hide();
					$("#divTab2").show();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#divTab3Details").click(function() {
					console.log("Tab3 Details");
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").show();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#divTab4Details").click(function() {
					console.log("Tab4 Details");
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").show();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#divTab5Details").click(function() {
					console.log("Tab5 Details");
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").show();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#divTab6Details").click(function() {
					console.log("Tab6 Details");
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").show();
					$("#divTab7").hide();
				});
				$("#divTab7Details").click(function() {
					console.log("Tab7 Details");
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").show();
				});

				$("#btnTab1Next").click(
						function() {
							console.log('Tab1 Next');
							$("#divTab2").show();
							$("#divTab1").hide();
							$("#divTab3").hide();
							$("#divTab4").hide();
							$("#divTab5").hide();
							$("#divTab6").hide();
							$("#divTab7").hide();

							$("#divTab1Details").attr('class',
									'mdl-stepper-step active-step step-done');
							$("#divTab1Details")
									.children(".mdl-stepper-circle").css(
											"background-color", "#9ACE2A");
							$("#divTab2Details").attr('class',
									'mdl-stepper-step active-step');

						});
				$("#btnTab2Next").click(
						function() {
							console.log('Tab2 Next');
							$("#divTab1").hide();
							$("#divTab2").hide();
							$("#divTab3").show();
							$("#divTab4").hide();
							$("#divTab5").hide();
							$("#divTab6").hide();
							$("#divTab7").hide();

							$("#divTab2Details").attr('class',
									'mdl-stepper-step active-step step-done');
							$("#divTab2Details")
									.children(".mdl-stepper-circle").css(
											"background-color", "#9ACE2A");
							$("#divTab3Details").attr('class',
									'mdl-stepper-step active-step');

						});
				$("#btnTab3Next").click(
						function() {
							console.log('Tab3 Next');
							$("#divTab1").hide();
							$("#divTab2").hide();
							$("#divTab3").hide();
							$("#divTab4").show();
							$("#divTab5").hide();
							$("#divTab6").hide();
							$("#divTab7").hide();

							$("#divTab3Details").attr('class',
									'mdl-stepper-step active-step step-done');
							$("#divTab3Details")
									.children(".mdl-stepper-circle").css(
											"background-color", "#9ACE2A");
							$("#divTab4Details").attr('class',
									'mdl-stepper-step active-step');

						});
				$("#btnTab4Next").click(
						function() {
							console.log('Tab4 Next');
							$("#divTab1").hide();
							$("#divTab2").hide();
							$("#divTab3").hide();
							$("#divTab4").hide();
							$("#divTab5").show();
							$("#divTab6").hide();
							$("#divTab7").hide();

							$("#divTab4Details").attr('class',
									'mdl-stepper-step active-step step-done');
							$("#divTab4Details")
									.children(".mdl-stepper-circle").css(
											"background-color", "#9ACE2A");
							$("#divTab5Details").attr('class',
									'mdl-stepper-step active-step');

						});
				$("#btnTab5Next").click(
						function() {
							console.log('Tab5 Next');
							$("#divTab1").hide();
							$("#divTab2").hide();
							$("#divTab3").hide();
							$("#divTab4").hide();
							$("#divTab5").hide();
							$("#divTab6").show();
							$("#divTab7").hide();

							$("#divTab5Details").attr('class',
									'mdl-stepper-step active-step step-done');
							$("#divTab5Details")
									.children(".mdl-stepper-circle").css(
											"background-color", "#9ACE2A");
							$("#divTab6Details").attr('class',
									'mdl-stepper-step active-step');

						});
				$("#btnTab6Next").click(
						function() {
							console.log('Tab6 Next');
							$("#divTab1").hide();
							$("#divTab2").hide();
							$("#divTab3").hide();
							$("#divTab4").hide();
							$("#divTab5").hide();
							$("#divTab6").hide();
							$("#divTab7").show();

							$("#divTab6Details").attr('class',
									'mdl-stepper-step active-step step-done');
							$("#divTab6Details")
									.children(".mdl-stepper-circle").css(
											"background-color", "#9ACE2A");
							$("#divTab7Details").attr('class',
									'mdl-stepper-step active-step');

						});

				$("#btnTab2Prev").click(function() {
					console.log('Tab2 Prev');
					$("#divTab1").show();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});

				$("#btnTab3Prev").click(function() {
					console.log('Tab2 Prev');
					$("#divTab1").hide();
					$("#divTab2").show();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#btnTab4Prev").click(function() {
					console.log('Tab2 Prev');
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").show();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#btnTab5Prev").click(function() {
					console.log('Tab2 Prev');
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").show();
					$("#divTab5").hide();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#btnTab6Prev").click(function() {
					console.log('Tab2 Prev');
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").show();
					$("#divTab6").hide();
					$("#divTab7").hide();
				});
				$("#btnTab7Prev").click(function() {
					console.log('Tab2 Prev');
					$("#divTab1").hide();
					$("#divTab2").hide();
					$("#divTab3").hide();
					$("#divTab4").hide();
					$("#divTab5").hide();
					$("#divTab6").show();
					$("#divTab7").hide();
				});

				$("#btnTab3Prev").click(function() {
					console.log('Tab3 Prev');
					$("#divTab2").show();
					$("#divTab3").hide();
					$("#divTab1").hide();
				});
				
				
				$("#btnAddTO").click(function(){
					console.log("Add turnover Entry");
		            var buyerName = $("#tTOBuyerName")[0].value;
		            var buyerCountry = $("#tTOBuyerCountry")[0].value;
		            if ($('input:checkbox[name=tTOIsAss]').is(':checked')){
		                var assDet = "Associate";
		            }
		            else{
		                var assDet = "Not an associate"
		            }
		            var noYears = $("#tTONoYears")[0].value;
					var indexTop = $("#tTOTop")[0].selectedIndex;
					var top = $("#tTOTop")[0][indexTop].text;
					var totShipVal = parseFloat($("#tTOShipVal")[0].value);
					var maxExp = parseFloat($("#tTOMaxExp")[0].value);
					var percentageExp = parseFloat($("#tTOPer")[0].value);
					$("#newExpTORow").append(
							`<tr>
		                    <td>
								`+buyerName+`
							</td>
							<td>
								`+buyerCountry+`
							</td>
		                    <td>
								`+assDet+`
							</td>
		                    <td>
								`+noYears+`
							</td>
		                    <td>
								`+top+`
							</td>
							<td>
							`+totShipVal+`
							</td>
							<td>
							`+maxExp+`
							</td>
		                    <td>
							`+percentageExp+`
							</td>
							<td><a class="fa fa-edit"> &nbsp;&nbsp; <a class="fa fa-trash"></a>
							</td>
		                </tr>`);
					$("#tTOBuyerName").val('');
					$("#tTOBuyerCountry").val('');
		            $('input:checkbox[name=tTOIsAss]').attr('checked',false);
					$("#tTONoYears").val('');
					$("#tTOTop").val('');
		            $("#tTOShipVal").val('');
		            $("#tTOMaxExp").val('');
		            $("#tTOPer").val('');
				});


			});
