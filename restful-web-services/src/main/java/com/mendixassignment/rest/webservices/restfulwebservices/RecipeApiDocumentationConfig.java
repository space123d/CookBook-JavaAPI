package com.mendixassignment.rest.webservices.restfulwebservices;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License; 
import io.swagger.annotations.SwaggerDefinition;
@SwaggerDefinition(
		info = @Info(
				description = "Recipe Resources",
				version = "V12.0.12",
				title = "Recipe Resource API",
				contact = @Contact(
						name = "Arjun Jayasimha",
						email = "space12.3d@gmail.com",
						url = ""
						),
				license = @License(
						name = "Apache 2.0",
						url =
						"http://www.apache.org/licenses/LICENSE-2.0"
						)
				),
		consumes = {"application/json", "application/xml"},
		produces = {"application/json", "application/xml"},
		schemes = {SwaggerDefinition.Scheme.HTTP,
				SwaggerDefinition.Scheme.HTTPS},
		externalDocs = @ExternalDocs(value = "Read this..", url = "https://github.com/space123d/CookBook-JavaAPI/blob/master/README.md")
		)
public interface RecipeApiDocumentationConfig {
}