import React, { useState, useRef, useCallback, useMemo } from "react";
import { Button } from "primereact/button";
import { Divider } from "primereact/divider";
import "primereact/resources/themes/lara-light-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import "primeflex/primeflex.css";
import "./MegaMenu.css";

// Type Definitions
interface MenuItem {
  label: string;
  icon: string;
}

interface MenuCategory {
  category: string;
  items: MenuItem[];
}

interface MenuData {
  label: string;
  icon: string;
  items: MenuCategory[];
}

// Constants
const HOVER_DELAY_MS = 100;
const NAV_HEIGHT = "60px";

const MENU_DATA: readonly MenuData[] = [
  {
    label: "Furniture",
    icon: "pi pi-box",
    items: [
      {
        category: "Living Room",
        items: [
          { label: "Accessories", icon: "pi pi-star" },
          { label: "Armchair", icon: "pi pi-star" },
          { label: "Coffee Table", icon: "pi pi-star" },
          { label: "Sofa", icon: "pi pi-star" },
        ],
      },
      {
        category: "Kitchen",
        items: [
          { label: "Bar Stool", icon: "pi pi-star" },
          { label: "Chair", icon: "pi pi-star" },
          { label: "Table", icon: "pi pi-star" },
          { label: "Cabinet", icon: "pi pi-star" },
        ],
      },
      {
        category: "Bedroom",
        items: [
          { label: "Bed", icon: "pi pi-star" },
          { label: "Dresser", icon: "pi pi-star" },
          { label: "Nightstand", icon: "pi pi-star" },
          { label: "Wardrobe", icon: "pi pi-star" },
        ],
      },
    ],
  },
  {
    label: "Electronics",
    icon: "pi pi-mobile",
    items: [
      {
        category: "Computer",
        items: [
          { label: "Monitor", icon: "pi pi-desktop" },
          { label: "Mouse", icon: "pi pi-desktop" },
          { label: "Keyboard", icon: "pi pi-desktop" },
          { label: "Laptop", icon: "pi pi-desktop" },
        ],
      },
      {
        category: "Mobile",
        items: [
          { label: "Phone", icon: "pi pi-mobile" },
          { label: "Tablet", icon: "pi pi-mobile" },
          { label: "Smartwatch", icon: "pi pi-mobile" },
        ],
      },
      {
        category: "Audio",
        items: [
          { label: "Headphones", icon: "pi pi-volume-up" },
          { label: "Speakers", icon: "pi pi-volume-up" },
          { label: "Microphone", icon: "pi pi-volume-up" },
        ],
      },
    ],
  },
  {
    label: "Clothing",
    icon: "pi pi-shopping-bag",
    items: [
      {
        category: "Men",
        items: [
          { label: "Shirts", icon: "pi pi-user" },
          { label: "Pants", icon: "pi pi-user" },
          { label: "Shoes", icon: "pi pi-user" },
          { label: "Accessories", icon: "pi pi-user" },
        ],
      },
      {
        category: "Women",
        items: [
          { label: "Dresses", icon: "pi pi-user" },
          { label: "Tops", icon: "pi pi-user" },
          { label: "Shoes", icon: "pi pi-user" },
          { label: "Bags", icon: "pi pi-user" },
        ],
      },
    ],
  },
  {
    label: "Sports",
    icon: "pi pi-flag",
    items: [
      {
        category: "",
        items: [],
      },
      {
        category: "Outdoor",
        items: [
          { label: "Camping", icon: "pi pi-sun" },
          { label: "Hiking", icon: "pi pi-sun" },
          { label: "Cycling", icon: "pi pi-sun" },
        ],
      },
      {
        category: "Indoor",
        items: [
          { label: "Gym Equipment", icon: "pi pi-heart" },
          { label: "Yoga", icon: "pi pi-heart" },
          { label: "Weights", icon: "pi pi-heart" },
        ],
      },
    ],
  },
] as const;

// Component Props
interface MenuLinkProps {
  item: MenuItem;
  onHover: (label: string) => void;
  onLeave: () => void;
  onClick: (label: string) => void;
}

interface MegaMenuPanelProps {
  menu: MenuData;
  isActive: boolean;
  onMouseEnter: () => void;
  onMouseLeave: () => void;
  hoveredItem: string | null;
  onItemHover: (label: string) => void;
  onItemLeave: () => void;
}

interface MobileMenuItemProps {
  menu: MenuData;
  index: number;
  isActive: boolean;
  onToggle: (index: number) => void;
  onItemClick: (label: string) => void;
}

// Subcomponents
const MenuLink: React.FC<MenuLinkProps> = React.memo(
  ({ item, onHover, onLeave, onClick }) => (
    <a
      href="#"
      className="menu-link"
      onMouseEnter={() => onHover(item.label)}
      onMouseLeave={onLeave}
      onClick={(e) => {
        e.preventDefault();
        onClick(item.label);
      }}
      role="menuitem"
    >
      <i className={item.icon} aria-hidden="true" />
      <span>{item.label}</span>
    </a>
  )
);

MenuLink.displayName = "MenuLink";

const MegaMenuPanel: React.FC<MegaMenuPanelProps> = React.memo(
  ({
    menu,
    isActive,
    onMouseEnter,
    onMouseLeave,
    hoveredItem,
    onItemHover,
    onItemLeave,
  }) => (
    <div
      className={`megamenu-panel ${isActive ? "show" : ""}`}
      onMouseEnter={onMouseEnter}
      onMouseLeave={onMouseLeave}
      role="menu"
      aria-label={`${menu.label} menu`}
    >
      <div className="p-5">
        <div className="grid">
          {menu.items.map((category, catIndex) => (
            <section key={catIndex} className="col-12 md:col-6 lg:col-4">
              {category.category && (
                <h3 className="category-title">{category.category}</h3>
              )}
              <nav className="flex flex-column gap-1" role="none">
                {category.items.map((item, itemIndex) => (
                  <MenuLink
                    key={itemIndex}
                    item={item}
                    onHover={onItemHover}
                    onLeave={onItemLeave}
                    onClick={(label) => console.log("Clicked:", label)}
                  />
                ))}
              </nav>
            </section>
          ))}
        </div>
        <Divider />
        <div className="item-description" role="status" aria-live="polite">
          {hoveredItem || "Hover over an item to see its description"}
        </div>
      </div>
    </div>
  )
);

MegaMenuPanel.displayName = "MegaMenuPanel";

const MobileMenuItem: React.FC<MobileMenuItemProps> = React.memo(
  ({ menu, index, isActive, onToggle, onItemClick }) => (
    <article className="mobile-menu-item">
      <button
        className="mobile-menu-header"
        onClick={() => onToggle(index)}
        aria-expanded={isActive}
        aria-controls={`mobile-menu-content-${index}`}
      >
        <div className="flex align-items-center gap-2">
          <i className={menu.icon} aria-hidden="true" />
          <span className="font-semibold">{menu.label}</span>
        </div>
        <i
          className={`pi ${isActive ? "pi-angle-up" : "pi-angle-down"}`}
          aria-hidden="true"
        />
      </button>
      <div
        id={`mobile-menu-content-${index}`}
        className={`mobile-menu-content ${isActive ? "open" : ""}`}
        role="region"
        aria-labelledby={`mobile-menu-header-${index}`}
      >
        {menu.items.map((category, catIndex) => (
          <div key={catIndex} className="mobile-category">
            {category.category && (
              <h4 className="mobile-category-title">{category.category}</h4>
            )}
            {category.items.map((item, itemIndex) => (
              <a
                key={itemIndex}
                href="#"
                className="menu-link"
                onClick={(e) => {
                  e.preventDefault();
                  onItemClick(item.label);
                }}
                role="menuitem"
              >
                <i className={item.icon} aria-hidden="true" />
                <span>{item.label}</span>
              </a>
            ))}
          </div>
        ))}
      </div>
    </article>
  )
);

MobileMenuItem.displayName = "MobileMenuItem";

// Main Component
const CustomMegaMenu: React.FC = () => {
  const [activeMenu, setActiveMenu] = useState<number | null>(null);
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);
  const [hoveredItem, setHoveredItem] = useState<string | null>(null);
  const hoverTimeoutRef = useRef<NodeJS.Timeout | null>(null);

  const handleItemHover = useCallback((label: string) => {
    if (hoverTimeoutRef.current) {
      clearTimeout(hoverTimeoutRef.current);
    }
    setHoveredItem(label);
  }, []);

  const handleItemLeave = useCallback(() => {
    if (hoverTimeoutRef.current) {
      clearTimeout(hoverTimeoutRef.current);
    }
    hoverTimeoutRef.current = setTimeout(() => {
      setHoveredItem(null);
    }, HOVER_DELAY_MS);
  }, []);

  const handleMenuLeave = useCallback(() => {
    setActiveMenu(null);
    setHoveredItem(null);
    if (hoverTimeoutRef.current) {
      clearTimeout(hoverTimeoutRef.current);
    }
  }, []);

  const toggleMobileMenu = useCallback((index: number) => {
    setActiveMenu((prev) => (prev === index ? null : index));
  }, []);

  const handleMobileItemClick = useCallback((label: string) => {
    console.log("Clicked:", label);
    setMobileMenuOpen(false);
  }, []);

  const handleHamburgerClick = useCallback(() => {
    setMobileMenuOpen((prev) => !prev);
  }, []);

  // Memoized menu data to prevent unnecessary re-renders
  const menuData = useMemo(() => MENU_DATA, []);

  return (
    <div className="min-h-screen bg-gray-50">
      <header>
        <nav className="custom-megamenu" role="navigation" aria-label="Main navigation">
          <div className="flex align-items-center justify-content-between px-4">
            {/* Desktop Menu */}
            <ul className="desktop-menu" onMouseLeave={handleMenuLeave} role="menubar">
              {menuData.map((menu, index) => (
                <li key={index} className="menu-container" role="none">
                  <button
                    className={`menu-item ${activeMenu === index ? "active" : ""}`}
                    onMouseEnter={() => setActiveMenu(index)}
                    aria-haspopup="true"
                    aria-expanded={activeMenu === index}
                    role="menuitem"
                  >
                    <div className="flex align-items-center gap-2">
                      <i className={menu.icon} aria-hidden="true" />
                      <span className="font-semibold">{menu.label}</span>
                      <i className="pi pi-angle-down text-sm" aria-hidden="true" />
                    </div>
                  </button>

                  <MegaMenuPanel
                    menu={menu}
                    isActive={activeMenu === index}
                    onMouseEnter={() => setActiveMenu(index)}
                    onMouseLeave={handleMenuLeave}
                    hoveredItem={hoveredItem}
                    onItemHover={handleItemHover}
                    onItemLeave={handleItemLeave}
                  />
                </li>
              ))}
            </ul>

            {/* Mobile Hamburger */}
            <Button
              icon={mobileMenuOpen ? "pi pi-times" : "pi pi-bars"}
              className="hamburger-btn"
              text
              onClick={handleHamburgerClick}
              aria-label={mobileMenuOpen ? "Close menu" : "Open menu"}
              aria-expanded={mobileMenuOpen}
              aria-controls="mobile-menu"
            />
          </div>

          {/* Mobile Menu */}
          <aside
            id="mobile-menu"
            className={`mobile-menu ${mobileMenuOpen ? "open" : ""}`}
            aria-hidden={!mobileMenuOpen}
          >
            {menuData.map((menu, index) => (
              <MobileMenuItem
                key={index}
                menu={menu}
                index={index}
                isActive={activeMenu === index}
                onToggle={toggleMobileMenu}
                onItemClick={handleMobileItemClick}
              />
            ))}
          </aside>
        </nav>
      </header>

      <main className="p-4" style={{ marginTop: NAV_HEIGHT }}>
        <article className="card p-4 text-center">
          <h1 className="text-2xl md:text-3xl font-bold mb-3">
            Responsive Custom Mega Menu
          </h1>
          <p className="text-gray-600 mb-4">
            Hover on desktop or tap on mobile to see the mega menu
          </p>
        </article>
      </main>
    </div>
  );
};

CustomMegaMenu.displayName = "CustomMegaMenu";

export default CustomMegaMenu;
