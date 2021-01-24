package kganesh1795_ecompg.web.api;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookImages")
public class BookImagesResource {
    @Autowired
    public MongoOperations mongoOps;
    
    @GetMapping
    public List<String> getBookImages() {
        Document result = mongoOps.executeCommand("{find: 'bookImages', projection: {_id: false}}");
        
        Document cursor = result.get("cursor", Document.class);
        List<Document> firstBatch = cursor.get("firstBatch", List.class);
        
        List<String> resultJson = firstBatch.stream()
                .map(d -> (String)d.get("Image"))
                .collect(Collectors.toList());
        
        return resultJson;
    }
    
}
