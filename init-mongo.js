db.createUser (
	{
		user : "admin",
		pwd : "admin",
		roles : [
			{
			role : "readWrite",
			db : "jot_db"
			}
		]
	}