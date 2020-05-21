$(document).ready(function() {


    function filterColumn(i) {
      $('#example1').DataTable().column(i).search(
        $('#col' + i + '_filter').val(),
        $('#col' + i + '_smart').prop('checked')
      ).draw();
    }

    
      $('#example1').DataTable();

      

      $('input.column_filter').on('keyup click', function() {
       
           var a=$(this);
        filterColumn($(this).parents('tr').attr('data-column'));
      console.log(a);
   
         
      });
    
});
