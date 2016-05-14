require.config({
	baseUrl : jsBase,
	paths : {
		"jquery" : ["corelib/jquery.min"],
		"amazeui" : ["corelib/amazeui.min"],
	    "main" : ["common/main"],
	    "app" : ["common/app"],
	    "shop" : ["common/shop"]
	},
	shim : {
		"app" : {
			deps : ["jquery"]
		},
		"amazeui" : {
			deps : ["jquery"]
		},
		"main" : {
			deps : ["jquery"]
		},
		"shop" : {
			deps : ["jquery", "app"]
		}
	}
});
