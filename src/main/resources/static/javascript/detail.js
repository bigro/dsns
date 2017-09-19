$(function() {
    $("#deleteButton").on('click',function(){
        if(!confirm('本当に削除しますか？')){
            return false;
        }else{
            $("#deleteForm").submit();
        }
    });
});