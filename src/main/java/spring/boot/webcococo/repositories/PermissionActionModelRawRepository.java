package spring.boot.webcococo.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.webcococo.entities.PermissionActionModelRaw;

import java.util.List;

//import spring.boot.authenauthor.entities.PermissionActionRaw;
@Repository
public interface PermissionActionModelRawRepository extends BaseRepository<PermissionActionModelRaw,Long> {

    List<PermissionActionModelRaw> findByPermissionId(Integer permissionId);
    @Query(value = "    SELECT COUNT(*)\n" +
            "    FROM permission_model_action_raw pamr\n" +
            "    JOIN user_permissions up ON pamr.permission_id = up.permission_id\n" +
            "    JOIN users u ON up.user_id = u.id\n" +
            "    JOIN permissions p  ON up.permission_id  = p.id\n" +
            "    LEFT JOIN models m ON pamr.model_id = m.id\n" +
            "    LEFT JOIN actions a ON pamr.action_id = a.id\n" +
            "    WHERE (m.name IS NULL OR m.name = :modelName)\n" +
            "    AND (a.name IS NULL OR a.name = :actionName)\n" +
            "    AND (u.email = :userEmail OR( u.email = :userEmail  AND p.name  = 'ADMIN'));", nativeQuery = true)
    Long countActionModelRawAuthors(String userEmail, String actionName, String modelName);




//    SELECT *
//    FROM permission_model_action_raw pamr
//    JOIN user_permissions up ON pamr.permission_id = up.permission_id
//    JOIN users u ON up.user_id = u.id
//    JOIN permissions p  ON up.permission_id  = p.id
//    LEFT JOIN models m ON pamr.model_id = m.id
//    LEFT JOIN actions a ON pamr.action_id = a.id
//    WHERE (m.name IS NULL OR m.name = :modelName)
//    AND (a.name IS NULL OR a.name = :actionName)
//    AND (pamr.raw_id IS NULL OR pamr.raw_id = :rawId)
//    AND (u.email = :userEmail OR( u.email = :userEmail  AND p.name  = 'ADMIN'));




    @Query(value = "SELECT COUNT(*) AS total_count\n" +
            "FROM permission_model_action_raw pamr\n" +
            "LEFT JOIN models m ON pamr.model_id = m.id\n" +
            "LEFT JOIN actions a ON pamr.action_id = a.id\n" +
            "JOIN user_permissions up ON pamr.permission_id = up.permission_id\n" +
            "JOIN users u ON up.user_id = u.id\n" +
            "JOIN permissions p ON up.permission_id = p.id\n" +
            "WHERE m.name = :modelName\n" +
            "  AND a.name = :actionName\n" +
            "  AND pamr.raw_id = :rawId\n" +
            "  AND (\n" +
            "      u.email = :userEmail\n" +
            "      OR (u.email = :userEmail AND p.name = 'ADMIN')\n" +
            "  );", nativeQuery = true)
    Long countActionModelRawAuthors(String userEmail, Integer rawId, String actionName, String modelName);











//    @Query(value = "SELECT COUNT(pamr.id) " +
//            "FROM permission_action_model_raw pamr " +
//            "JOIN model m ON pamr.model_id = m.id " +
//            "JOIN action a ON pamr.action_id = a.id " +
//            "JOIN users_permission up ON pamr.permission_id = up.permission_id " +
//            "JOIN users u ON up.user_id = u.id " +
//            "WHERE m.name = :model " +
//            "AND a.name = :action " +
//            "AND pamr.raw_id = :rawId " +
//            "AND u.name = :userName", nativeQuery = true)
//    Long countActionModelRawAuthors(@Param("userName") String userName,
//                                    @Param("rawId") Integer rawId,
//                                    @Param("action") String actionName,
//                                    @Param("model") String modelName);

    }
















//    @Query(value = "SELECT DISTINCT action_id FROM permission_action_raw WHERE permission_id = :permissionId", nativeQuery = true)
//    List<Integer> findActionIdsByPermissionId(@Param("permissionId")Integer permissionId);
//
//
//
//
//    @Query(value = "SELECT posts_id FROM permission_action_raw WHERE permission_id = :permissionId AND action_id = :actionId", nativeQuery = true)
//    List<Integer> findPostIdsByPermissionAndAction(@Param("permissionId") Integer permissionId, @Param("actionId") Integer actionId);
//


//    @Query(value = "SELECT COUNT(*) > 0 " +
//            "FROM permission_action_raw par " +
//            "JOIN actions a ON par.action_id = a.id " +
//            "WHERE par.permission_id = :permissionId " +
//            "AND par.posts_id = :postId " +
//            "AND a.name = :actionName", nativeQuery = true)



//}
//
//