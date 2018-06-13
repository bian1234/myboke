//Setup flex slider
$(window).load(function () {
    $('.gf-slider').flexslider();
});
//Setup Page
$(document).ready(function () {
    //Initialize PrettyPhoto here
    $("a[rel^='prettyPhoto']").prettyPhoto({ animation_speed: 'normal', theme: 'facebook', slideshow: 3000, autoplay_slideshow: false, social_tools: false 	});
	
	//Remove this line if you want to naviagate to url on each client box click
	$('#clients.grid a').click(function(){return false;});
    //Initialize jQuery knob here
    $(".knob").knob();
    //Initialie tipsy here
    $('#fb').tipsy({ gravity: 'n', fade: true });
    $('#tw').tipsy({ gravity: 'n', fade: true });
    $('#ld').tipsy({ gravity: 'n', fade: true });
    /* smooth-scroll */
    $("ul#navigation a").smoothScroll({
        afterScroll: function () {
            $('ul#navigation a.active').removeClass('active');
            $(this).addClass('active');
        }
    });

    //Scroll
    $('div.page').waypoint(function () {
        var id = $(this).attr('id');

        $('ul#navigation a.active').removeClass('active');
        $('ul#navigation a[href="#' + id + '"]').addClass('active');
    });

    /* fixes */
    $(window).scroll(function () {
        if ($(window).scrollTop() === 0) {
            $('ul#navigation a.active').removeClass('active');
            $('ul#navigation a[href="#home"]').addClass('active');
        } else if ($(window).height() + $(window).scrollTop() === $('#container').height()) {
            $('ul#navigation a.active').removeClass('active');
            $('ul#navigation a[href^="#"]:last').addClass('active');
        }
    });

    /* tab */
    // first selector
    $('.tab').each(function () {
        $(this).find('ul > li:first').addClass('active');
        $(this).find('div.tab_container > div:first').addClass('active');
    });

    /* toggles */
    $('.toggle h3').click(function () {
        $(this).parent().find('.toggle_data').slideToggle();
    });

    // click functions
    $('.tab > ul > li').click(function () {
        $(this).parent().find('li.active').removeClass('active');
        $(this).addClass('active');

        $(this).parent().parent().find('div.tab_container > div.active').removeClass('active').slideUp();
        $(this).parent().parent().find('div.tab_container > div#' + $(this).attr('id')).slideDown().addClass('active');

        return false;
    });

    var $container = $('div#works').isotope({
        itemSelector: 'img.work',
        layoutMode: 'fitRows'
    });

    // items filter
    $('#works_filter a').click(function () {
        var selector = $(this).attr('data-filter');
        $('div#works').isotope({
            filter: selector,
            itemSelector: 'img.work',
            layoutMode: 'fitRows'
        });

        $('#works_filter').find('a.selected').removeClass('selected');
        $(this).addClass('selected');

        return false;
    });

    //smooth scroll top
    $('.gotop').addClass('hidden');

    $("a.gotop").smoothScroll();

    $('#wrap').waypoint(function (event, direction) {
        $('.gotop').toggleClass('hidden', direction === "up");
    }, {
        offset: '-100%'
    });
    //bind send message here
    $('#submit').click(sendMessage);
});

/* Contact Form */
function checkEmail(email) {
    var check = /^[\w\.\+-]{1,}\@([\da-zA-Z-]{1,}\.){1,}[\da-zA-Z-]{2,6}$/;
    if (!check.test(email)) {
        return false;
    }
    return true;
}

function sendMessage() {
    // receive the provided data
    var name = $("input#name").val();
    var email = $("input#email").val();
    var subject = $("input#subject").val();
    var msg = $("textarea#msg").val();

    // check if all the fields are filled
    if (name == '' || name == 'Full Name*' || email == '' || email == 'Email Address*' || subject == '' || subject == 'Subject*' || msg == '' || msg == 'Your Message*') {
        $("div#msgs").html('<p class="warning">请完整的填写您的信息</p>');

        return false;
    }

    // verify the email address
    if (!checkEmail(email)) {
        $("div#msgs").html('<p class="warning">请填写正确的邮箱格式</p>');
        return false;
    }

    // make the AJAX request
    var dataString = $('#cform').serialize();
    $.ajax({
        type: "POST",
        url: '/message/insert',
        data: dataString,
        dataType: 'json',
        success: function (restUtil) {
            if (restUtil.status == 20001) {
                var errors = '<ul><li>';
                if (data.message.fullname != '')
                    errors += data.message.fullname + '</li>';
                if (data.message.emailaddress != '')
                    errors += '<li>' + data.message.emailaddress + '</li>';
                if (data.message.phonenumber != '')
                    errors += '<li>' + data.message.phonenumber + '</li>';
                if (data.message.subject != '')
                    errors += '<li>' + data.message.subject + '</li>';
                if (data.message.message != '')
                    errors += '<li>' + data.message.message + '</li>';

                $("div#msgs").html('<p class="error">无法完成您的请求。请参阅下面的错误!</p>' + errors);
            }
            else if (restUtil.status  == 20000) {

                $("div#msgs").html('<p class="error">留言已收悉，我们会尽快回复您。</p>');

            }

        },
        error: function () {
            $("div#msgs").html('<p class="error">未知错误，请联系中边！</p>');
        }
    });

    return false;
}