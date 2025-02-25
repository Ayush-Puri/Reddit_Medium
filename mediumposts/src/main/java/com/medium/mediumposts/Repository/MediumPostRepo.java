package com.medium.mediumposts.Repository;

import org.springframework.stereotype.Repository;

import com.medium.mediumposts.Document.MediumPost;


/**
 *
 * @author ayushpuri
 */
@Repository
 public interface MediumPostRepo extends MongoRepository<MediumPost, Integer> {
}
