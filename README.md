# TestsKotlinGraphQL
Repository to study


#To test graphQL
http://localhost:8080/graphiql

1- Sample Query
{
      getUserById(id:"1") {
    		id
        name
    }
}

2- Query with relationship
{
      getUserById(id:"1") {
    		id
        name
        addressess {
          id
          zipCode
        }

    }
}