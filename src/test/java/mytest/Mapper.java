/**
 *    Copyright 2009-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package mytest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.submitted.automapping.Article;

import java.util.List;

public interface Mapper {

  default String testDefault(String str){
    return str;
  };

  User getUser(Integer id);

  User getUserWithPhoneNumber(Integer id);

  User getUserWithPets_Inline(Integer id);

  User getUserWithPets_External(Integer id);

  List<Book> getBooks();

  Article getArticle();

  @Select("select 1")
  String ping();

  @Select("select id, name from users where id = #{id} and deleted = #{deleted}")
  User getUserById(@Param("id") int id, @Param("deleted") boolean deleted);
}
