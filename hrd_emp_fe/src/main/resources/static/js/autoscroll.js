    $("#divViewEmplmedaProposal").hide();


    /* Ajax call to get selected proposal data for updation purpose where ajax call returns proposal object */
    function viewEmplmedaProposal() {
      // alert("emplmedaProposalId:"+emplmedaProposalId);

      $("#divViewEmplmedaProposal").css("display", "block");
      $("#divEmplmedaProposal").css("display", "none");;
      $('html, body').animate({
        scrollTop: $("#divViewEmplmedaProposal")
          .offset().top
      }, 0);

    }

