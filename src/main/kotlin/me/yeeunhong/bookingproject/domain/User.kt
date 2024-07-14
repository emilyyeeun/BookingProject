package me.yeeunhong.bookingproject.domain

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
class User : BaseTime(), UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long = 1

    @Column(name = "username", unique = true, nullable = false)
    private var username: String = ""

    @Column(name = "password", nullable = false)
    private var password: String = ""

    @ElementCollection(fetch = FetchType.EAGER)
    var roles: List<String> = ArrayList()

    override fun getAuthorities(): Collection<GrantedAuthority> {
            return roles.map { role -> SimpleGrantedAuthority(role) }
    }
    override fun getUsername() = username
    override fun getPassword() = password
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}