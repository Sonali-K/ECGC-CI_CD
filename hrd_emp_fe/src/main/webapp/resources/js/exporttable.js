  $(document).ready(function() {
      var table = $('#example1').DataTable({
"order": [[ 1, "desc" ]],
        dom:  "<'row'<'col-sm-6'l><'col-sm-6'f>>" +"<'row'<'col-sm-12'tr>>" +
         "<'row'<'col-sm-6'i><'col-sm-6'p>>",

        lengthChange: true,
        buttons: [{
            extend: 'collection',
            text: 'Export',
            buttons: [
              'copy',
              'excel',
              'csv',
              'print',
               'pdf',
            ]
          },


          // 'copy', 'excel', 'pdf', 'colvis'

        ],
"initComplete": function(settings){
            $('#example1 thead th').each(function () {
               var $td = $(this);
		console.log($td[0]);
			if($td=='th.sorting')
                           $td.attr('title', "no sort");
			else
			    $td.attr('title', "sort");
            });

           
        }
      });

      table.buttons().container()
        .appendTo('.exportbuttons:eq(0)');

    });
