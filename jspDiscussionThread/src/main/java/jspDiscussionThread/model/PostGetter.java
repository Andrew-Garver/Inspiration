/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspDiscussionThread.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cswor
 */
public class PostGetter implements PostDataHandler {

    public PostGetter(String fileName) {
        this.fileName = fileName;
    }
    
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public List<Post> getNewPosts() {
        List<Post> posts = new ArrayList<Post>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFileName()));

            String line;

            while ((line = reader.readLine()) != null) {
                Post post = new Post();
                    post.loadFromFileString(line);
                    posts.add(post);
            }
        } catch (IOException e) { 
            e.printStackTrace();
        }
        return posts;
    }
    
    public void addPost(Post post) {
        try {
               BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(), true));
               writer.write(post.toFileString() + "\n");
               writer.close(); 

          } catch (IOException e) { 
               e.printStackTrace();
          }
    }
}
