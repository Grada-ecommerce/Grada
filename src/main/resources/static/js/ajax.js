function getReccProducts() {
    $.ajax({
        url: "https://jsonplaceholder.typicode.com/posts?userId=1",

        success: function (data) {
            var img = "data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
            var myNode = document.getElementById("grid");
            while (myNode.firstChild) {
                myNode.removeChild(myNode.firstChild);
            }
            data.forEach(post => {
                var $tr = $('<div class="col-lg-3">').append(
                    $('<img class="rounded-circle" width="140" height="140">').attr('src',img),
                    $('<h2>').text(post.title),
                    $('<p class="lead">').text(post.body)
                    $('<a class="btn btn-secondary">')
                ).appendTo('#grid');
                //console.log($tr.wrap('<p>').html());
            });
        }
    });
}