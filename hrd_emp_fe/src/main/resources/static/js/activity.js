$(document).ready(function() {

  $(".delete").on('click', function() {
    $('.case:checkbox:checked').parents("tr").remove();
  });

  var i = 2;
  $(".addmore").on('click', function() {
    count = $('table tr').length;
    var data = "<tr><td><input type='checkbox' class='case'/></td>"+
				"<td><span id='snum" + i + "'>" + count + ".</span></td>"+
				"<td><input type='text' placeholder='first name' class='form-control input-md'/></td> "+
				"<td><input type='text'  placeholder='last name'  class='form-control input-md'/></td>"+
				"<td><select class='form-control'>" +
					"<option value='' hidden>Select</option>"+
					"<option value='volvo'>Volvo</option>"+
					"<option value='saab'>Saab</option>"+
					"<option value='fiat'>Fiat</option>"+
					"<option value='audi'>Audi</option>" +
				"</select></td>"+
				"<td><input type='text'  placeholder='email'  class='form-control input-md'></td>"+
				"<td><input type='radio'input-md'/></td>"+
				"<td><input type='radio'input-md'/></td>"+
				"<td><input type='checkbox' input-md'/></td>"+
				"<td><input type='checkbox' input-md'/></td>"+
				"<td><input type='datetime-local'  input-md'/></td>"+
				"<td><input type='date'  input-md'/></td>";
    $('table').append(data);
    i++;
  });

  $('#json').on('click', function() {
    var datac = $("#example").tableToJson();

    console.log("JSON: ", datac);
    document.getElementById("show").innerHTML = datac;
  });

});
