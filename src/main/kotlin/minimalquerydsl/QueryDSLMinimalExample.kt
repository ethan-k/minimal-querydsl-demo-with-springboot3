package minimalquerydsl

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository


@SpringBootApplication
class QueryDSLMinimalExample(
    private val postRepository: PostRepository,
    private val em: EntityManager
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        for (i in 0..10) {
            postRepository.save(Post())
        }

        val queryFactory = JPAQueryFactory(em)
        val posts = queryFactory.from(QPost.post)
            .fetch()
        for (post in posts) {
            println(post)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<QueryDSLMinimalExample>(*args)
}

@Entity
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long = 0
    override fun toString(): String {
        return "Post(id=$id)"
    }
}

interface PostRepository : JpaRepository<Post, Long>