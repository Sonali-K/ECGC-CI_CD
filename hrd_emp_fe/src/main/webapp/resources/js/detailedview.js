$(document).ready( function () {
  //$('#example1').DataTable();
    $('#divRegDetails').hide();

   $('.btnViewDetails').click(function(){
    	$('#divRegDetails').show();
    });
    //	console.log($(this).attr('name'));
    //	var iec = $(this).attr('name');

    $("button[name='btnApprove']").click(function() {
      console.log('Approved');
    //$('.btnApprove .btnReject').attr('style','display:none;');
    $(this).parent('td.btnApprove').siblings('td.btnReject').attr('style', 'display:none;');
    //$('.btnApprove').attr('style', 'display:none;');
     $(this).parent('td.btnApprove').attr('style', 'display:none;');
      $(this).parent('td.btnApprove').siblings('td.btnEdit').attr('style', 'display:"";');
      $(this).parent('td.btnApprove').siblings('th').children('span').attr('class', 'badge badge-success').text('Approved');

    });

    $("button[name='btnReject']").click(function() {
      console.log('Rejected');
      $(this).parent('td.btnReject').siblings('td.btnApprove').attr('style', 'display:none;');
      $(this).parent('td.btnReject').attr('style', 'display:none;');
      $(this).parent('td.btnReject').siblings('td.btnEdit').attr('style', 'display:"";');
      $(this).parent('td.btnReject').siblings('th').children('span').attr('class', 'badge badge-danger').text('Rejected');

    });

    $(".btnEdit").click(function() {

      var value = $(this).attr('val');
      console.log(value);

      $($(this).parent()[0]).children('td.btnApprove').attr('style', 'display:"";')
      $($(this).parent()[0]).children('td.btnReject').attr('style', 'display:"";')
      $(this).attr('style', 'display:none;');
      console.log();
    });



    });

