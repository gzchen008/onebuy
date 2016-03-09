
var tplEngine = function(tpl) {
var code='function str2ent(str){if(typeof str != "string")return str;var s="";for(var i=0;i<str.length;i++){if(str[i]=="<")s+="&lt;";else if(str[i]==">")s+="&gt;";else s+=str[i];}return s;}';
code+='var r=[];{\n';
	function add(str,isjs){
		while(str[0]==' '||str[0]=='\n'||str[0]=='\t'||str[0]=='\r')str=str.slice(1);
		while(str[str.length-1]==' '||str[str.length-1]=='\n'||str[str.length-1]=='\t'||str[str.length-1]=='\r')str=str.slice(0,str.length-1);
		if(isjs){
			var first_str=str.substring(0,1);//为了兼容IE6
			if(first_str!='='){
				code+=str+'\n';
			}else{
				code+='r.push(str2ent('+str.slice(1)+'));\n';
			}
		}else{
			var s="";
			for(var i=0;i<str.length;i++){
				if(str[i]=='"')s+='\\"';
				else if(str[i]=='\n')s+='\\n';
				else s+=str[i];
			}
			if(s!=""){
				code+='r.push("'+s+'");\n';
			}
		}
	}
	var cursor = 0;
	var getmatch=function(){
		var s0="";
		var s1="";
		for(var i=cursor;i<tpl.length;i++){
			if(tpl[i]=='<' && tpl[i+1]=="%"){
				for(var j=i+2;j<tpl.length;j++){
					if(tpl[j]=="%" && tpl[j+1]==">"){
						cursor=j+2;
						return [0,s0,s1];
					}else if(tpl[j]=='<' && tpl[j+1]=="%"){
						throw tpl.slice(0,j)+"\nerror 0\n"+tpl.slice(j);
					}else{
						s1+=tpl[j];
					}
				}
				return [1,s0,s1];
			}else if(tpl[i]=='%' && tpl[i+1]==">"){
				throw tpl.slice(0,i)+"\nerror 1\n"+tpl.slice(i);
			}else{
				s0+=tpl[i];
			}
		}
		return [2,s0,s1];
	}
	var arr=null;
	while(arr=getmatch()){
		//console.log(arr);
		if(arr[0]==0){
			add(arr[1],false)
			add(arr[2],true);
		}
		if(arr[0]==1){
			add(arr[1]+"<%"+arr[2],false);
			break;
		}
		if(arr[0]==2){
			add(arr[1],false);
			break;
		}
	}
	code += '\n}\nreturn r.join("");';
	//console.log(code);
	var func=new Function('',code);
	//console.log(func);
	return func;
}
