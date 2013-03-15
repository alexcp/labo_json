var user_template = _.template('<div class="user"><h2><%= name %></h2><img src="<%= avatar %>" /><div class="score">Score: <%= score %></div><div class="repos">Repositories: <%= repos %></div><div class="followers">Followers: <%= followers %></div><div class="gist">Gists:<%= gist %></div></div>');


$(document).ready(function(){
  $("#score").submit(function(){
    
    var data = $("#score").serialize();
    var username = data.substr(data.indexOf("=")+1);
    $.ajax("/users/" + username,{
      data: data,
      dataType: "json",
      timeout: 8000,
      success:function(user){
        $("#get_score").html(user_template(user));
        display_user_list();
      }
    });
    return false;
  });

  display_user_list();

  function display_user_list(){
    $.ajax("/users",{
      dataType: "json",
      timeout: 8000,
      success:function(users){
        var user_list = '<% _.each(list,function(user){ %><tr class="user"><td><img src="<%= user.avatar %>" class="thumbnail" /></td><td><h3><%= user.name %></td><td class="score"><%= user.score %></td></tr> <% });%>';
        $("#liste").html(_.template(user_list,{list:users}));
      }
    });
  }
});
