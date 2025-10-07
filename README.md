/* Custom Mega Menu Styles */

.custom-megamenu {
  background: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1001;
}

.desktop-menu {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
}

.menu-container {
  position: relative;
}

.menu-item {
  position: relative;
  padding: 0.5rem 1.5rem;
  cursor: pointer;
  transition: all 0.3s ease;
  border-bottom: 3px solid transparent;
  background: none;
  border-top: none;
  border-left: none;
  border-right: none;
  font-size: inherit;
  font-family: inherit;
  color: inherit;
}

.menu-item:hover {
  background: #f8f9fa;
  border-bottom-color: #3b82f6;
}

.menu-item.active {
  background: #f8f9fa;
}

.megamenu-panel {
  position: fixed;
  top: 60px;
  left: 0;
  right: 0;
  background: white;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  opacity: 0;
  visibility: hidden;
  transform: translateY(-10px);
  transition: all 0.3s ease;
  z-index: 1000;
}

.megamenu-panel.show {
  opacity: 1;
  visibility: visible;
  transform: translateY(0);
  z-index: 1001;
}

.category-title {
  color: #1e293b;
  margin-bottom: 1rem;
  font-size: 1.1rem;
  padding-bottom: 0.5rem;
  font-weight: 600;
}

.menu-link {
  display: flex;
  align-items: center;
  padding: 0.75rem 1rem;
  color: #475569;
  text-decoration: none;
  border-radius: 6px;
  transition: all 0.2s ease;
  cursor: pointer;
}

.menu-link:hover {
  background: #f1f5f9;
  color: #3b82f6;
  text-decoration: none;
}

.menu-link i {
  margin-right: 0.5rem;
  font-size: 0.875rem;
}

.item-description {
  color: #64748b;
  font-size: 0.95rem;
  min-height: 24px;
  transition: opacity 0.15s ease;
}

.hamburger-btn {
  display: none;
}

.mobile-menu {
  display: none;
}

.mobile-menu-header {
  width: 100%;
  text-align: left;
  background: white;
  border: none;
  font-size: inherit;
  font-family: inherit;
  color: inherit;
  padding: 1rem;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.mobile-menu-header:active {
  background: #f8f9fa;
}

/* Mobile Styles */
@media screen and (max-width: 768px) {
  .hamburger-btn {
    display: block !important;
  }

  .desktop-menu {
    display: none !important;
  }

  .mobile-menu {
    display: block;
    position: fixed;
    top: 60px;
    left: 0;
    right: 0;
    bottom: 0;
    background: white;
    z-index: 1000;
    overflow-y: auto;
    transform: translateX(-100%);
    transition: transform 0.3s ease;
  }

  .mobile-menu.open {
    transform: translateX(0);
  }

  .mobile-menu-item {
    border-bottom: 1px solid #e2e8f0;
  }

  .mobile-menu-content {
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.3s ease;
    background: #f8f9fa;
  }

  .mobile-menu-content.open {
    max-height: 2000px;
  }

  .mobile-category {
    padding: 0.75rem 1rem;
    background: white;
    margin: 0.5rem 1rem;
    border-radius: 6px;
  }

  .mobile-category-title {
    font-weight: 600;
    color: #1e293b;
    margin-bottom: 0.5rem;
    font-size: 0.95rem;
  }

  .menu-item {
    padding: 0.75rem 1rem;
  }

  .menu-link {
    padding: 0.5rem 0.75rem;
    font-size: 0.9rem;
  }
}

/* Tablet Styles */
@media screen and (min-width: 769px) and (max-width: 1024px) {
  .menu-item {
    padding: 0.75rem 1rem;
    font-size: 0.9rem;
  }
}

/* Accessibility improvements */
.menu-link:focus-visible,
.menu-item:focus-visible,
.mobile-menu-header:focus-visible {
  outline: 2px solid #3b82f6;
  outline-offset: 2px;
}

/* Performance optimization */
.megamenu-panel {
  will-change: opacity, transform;
}

.mobile-menu {
  will-change: transform;
}

/* Hide screen reader only text visually */
.sr-only {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  white-space: nowrap;
  border-width: 0;
}
