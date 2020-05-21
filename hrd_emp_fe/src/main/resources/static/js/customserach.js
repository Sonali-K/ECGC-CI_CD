$(document).ready(function() {
function filterGlobal() {
      $('#example1').DataTable().search(
        $('#global_filter').val(),
        $('#global_regex').prop('checked'),
        $('#global_smart').prop('checked')
      ).draw();
    }

    function filterColumn(i) {
      $('#example1').DataTable().column(i).search(
        $('#col' + i + '_filter').val(),
        $('#col' + i + '_regex').prop('checked'),
        $('#col' + i + '_smart').prop('checked')
      ).draw();
    }

    $(document).ready(function() {
      $('#example1').DataTable();

      $('input.global_filter').on('keyup click', function() {
        filterGlobal();
      });

      $('input.column_filter').on('keyup click', function() {
        filterColumn($(this).parents('tr').attr('data-column'));
      });
    });
});
