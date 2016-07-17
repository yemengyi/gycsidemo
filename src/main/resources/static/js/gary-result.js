$(document).ready(
    function() {
        //$('.table').hide();

        $('#search_btn').on('click', function() {
            $.ajax({
                type: 'GET',
                contentType: 'application/json',
                url: '/gary-cx/' + $('#sfz_input').val(),
                dataType: 'json',
                success: function(res) {
                    $('.table').fadeIn(5000);

                    var html = '<tr><td>' + res.xm + '</td><td>' + res.sfzh
                        + '</td><td>' + res.dz + '</td></tr>';
                    $(html).prependTo('#gary_list');

                    /*
                     {
                     dz : 'xxx',
                     sfzh : 'xxx'
                     }
                     * */
                }
            });
        });
    }
);